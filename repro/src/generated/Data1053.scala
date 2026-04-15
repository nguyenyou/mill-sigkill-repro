package generated

final case class Data1053(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1053 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1053 = copy(value = value * k)
  def addTag(t: String): Data1053 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1053 = copy(meta = meta.updated(k, v))
  def merge(other: Data1053): Data1053 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1053 {
  given Ordering[Data1053] = Ordering.by(_.id)
  def empty: Data1053 = Data1053(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1053 =
    Data1053(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1053] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
