package generated

final case class Data1067(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1067 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1067 = copy(value = value * k)
  def addTag(t: String): Data1067 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1067 = copy(meta = meta.updated(k, v))
  def merge(other: Data1067): Data1067 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1067 {
  given Ordering[Data1067] = Ordering.by(_.id)
  def empty: Data1067 = Data1067(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1067 =
    Data1067(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1067] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
