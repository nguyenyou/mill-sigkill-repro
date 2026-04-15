package generated

final case class Data1063(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1063 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1063 = copy(value = value * k)
  def addTag(t: String): Data1063 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1063 = copy(meta = meta.updated(k, v))
  def merge(other: Data1063): Data1063 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1063 {
  given Ordering[Data1063] = Ordering.by(_.id)
  def empty: Data1063 = Data1063(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1063 =
    Data1063(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1063] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
