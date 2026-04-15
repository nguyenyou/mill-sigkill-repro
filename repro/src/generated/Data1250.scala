package generated

final case class Data1250(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1250 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1250 = copy(value = value * k)
  def addTag(t: String): Data1250 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1250 = copy(meta = meta.updated(k, v))
  def merge(other: Data1250): Data1250 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1250 {
  given Ordering[Data1250] = Ordering.by(_.id)
  def empty: Data1250 = Data1250(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1250 =
    Data1250(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1250] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
