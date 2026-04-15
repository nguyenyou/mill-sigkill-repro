package generated

final case class Data1356(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1356 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1356 = copy(value = value * k)
  def addTag(t: String): Data1356 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1356 = copy(meta = meta.updated(k, v))
  def merge(other: Data1356): Data1356 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1356 {
  given Ordering[Data1356] = Ordering.by(_.id)
  def empty: Data1356 = Data1356(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1356 =
    Data1356(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1356] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
