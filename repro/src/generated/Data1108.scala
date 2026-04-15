package generated

final case class Data1108(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1108 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1108 = copy(value = value * k)
  def addTag(t: String): Data1108 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1108 = copy(meta = meta.updated(k, v))
  def merge(other: Data1108): Data1108 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1108 {
  given Ordering[Data1108] = Ordering.by(_.id)
  def empty: Data1108 = Data1108(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1108 =
    Data1108(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1108] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
