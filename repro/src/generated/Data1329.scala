package generated

final case class Data1329(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1329 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1329 = copy(value = value * k)
  def addTag(t: String): Data1329 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1329 = copy(meta = meta.updated(k, v))
  def merge(other: Data1329): Data1329 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1329 {
  given Ordering[Data1329] = Ordering.by(_.id)
  def empty: Data1329 = Data1329(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1329 =
    Data1329(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1329] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
