package generated

final case class Data1209(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1209 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1209 = copy(value = value * k)
  def addTag(t: String): Data1209 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1209 = copy(meta = meta.updated(k, v))
  def merge(other: Data1209): Data1209 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1209 {
  given Ordering[Data1209] = Ordering.by(_.id)
  def empty: Data1209 = Data1209(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1209 =
    Data1209(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1209] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
