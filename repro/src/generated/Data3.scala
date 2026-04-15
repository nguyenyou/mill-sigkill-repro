package generated

final case class Data3(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data3 = copy(name = name.toUpperCase)
  def scale(k: Double): Data3 = copy(value = value * k)
  def addTag(t: String): Data3 = copy(tags = t :: tags)
  def put(k: String, v: String): Data3 = copy(meta = meta.updated(k, v))
  def merge(other: Data3): Data3 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data3 {
  given Ordering[Data3] = Ordering.by(_.id)
  def empty: Data3 = Data3(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data3 =
    Data3(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data3] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
