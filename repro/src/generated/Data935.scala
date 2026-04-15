package generated

final case class Data935(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data935 = copy(name = name.toUpperCase)
  def scale(k: Double): Data935 = copy(value = value * k)
  def addTag(t: String): Data935 = copy(tags = t :: tags)
  def put(k: String, v: String): Data935 = copy(meta = meta.updated(k, v))
  def merge(other: Data935): Data935 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data935 {
  given Ordering[Data935] = Ordering.by(_.id)
  def empty: Data935 = Data935(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data935 =
    Data935(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data935] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
