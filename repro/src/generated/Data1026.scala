package generated

final case class Data1026(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1026 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1026 = copy(value = value * k)
  def addTag(t: String): Data1026 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1026 = copy(meta = meta.updated(k, v))
  def merge(other: Data1026): Data1026 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1026 {
  given Ordering[Data1026] = Ordering.by(_.id)
  def empty: Data1026 = Data1026(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1026 =
    Data1026(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1026] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
