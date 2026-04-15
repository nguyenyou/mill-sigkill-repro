package generated

final case class Data1069(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1069 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1069 = copy(value = value * k)
  def addTag(t: String): Data1069 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1069 = copy(meta = meta.updated(k, v))
  def merge(other: Data1069): Data1069 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1069 {
  given Ordering[Data1069] = Ordering.by(_.id)
  def empty: Data1069 = Data1069(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1069 =
    Data1069(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1069] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
