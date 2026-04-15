package generated

final case class Data1001(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1001 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1001 = copy(value = value * k)
  def addTag(t: String): Data1001 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1001 = copy(meta = meta.updated(k, v))
  def merge(other: Data1001): Data1001 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1001 {
  given Ordering[Data1001] = Ordering.by(_.id)
  def empty: Data1001 = Data1001(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1001 =
    Data1001(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1001] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
