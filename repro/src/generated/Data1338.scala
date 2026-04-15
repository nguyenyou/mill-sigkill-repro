package generated

final case class Data1338(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1338 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1338 = copy(value = value * k)
  def addTag(t: String): Data1338 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1338 = copy(meta = meta.updated(k, v))
  def merge(other: Data1338): Data1338 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1338 {
  given Ordering[Data1338] = Ordering.by(_.id)
  def empty: Data1338 = Data1338(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1338 =
    Data1338(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1338] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
