package generated

final case class Data1298(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1298 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1298 = copy(value = value * k)
  def addTag(t: String): Data1298 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1298 = copy(meta = meta.updated(k, v))
  def merge(other: Data1298): Data1298 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1298 {
  given Ordering[Data1298] = Ordering.by(_.id)
  def empty: Data1298 = Data1298(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1298 =
    Data1298(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1298] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
