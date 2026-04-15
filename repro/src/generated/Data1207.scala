package generated

final case class Data1207(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1207 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1207 = copy(value = value * k)
  def addTag(t: String): Data1207 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1207 = copy(meta = meta.updated(k, v))
  def merge(other: Data1207): Data1207 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1207 {
  given Ordering[Data1207] = Ordering.by(_.id)
  def empty: Data1207 = Data1207(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1207 =
    Data1207(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1207] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
