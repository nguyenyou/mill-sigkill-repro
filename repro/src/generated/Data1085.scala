package generated

final case class Data1085(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1085 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1085 = copy(value = value * k)
  def addTag(t: String): Data1085 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1085 = copy(meta = meta.updated(k, v))
  def merge(other: Data1085): Data1085 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1085 {
  given Ordering[Data1085] = Ordering.by(_.id)
  def empty: Data1085 = Data1085(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1085 =
    Data1085(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1085] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
