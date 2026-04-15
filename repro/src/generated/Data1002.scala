package generated

final case class Data1002(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1002 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1002 = copy(value = value * k)
  def addTag(t: String): Data1002 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1002 = copy(meta = meta.updated(k, v))
  def merge(other: Data1002): Data1002 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1002 {
  given Ordering[Data1002] = Ordering.by(_.id)
  def empty: Data1002 = Data1002(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1002 =
    Data1002(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1002] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
