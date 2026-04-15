package generated

final case class Data1031(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1031 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1031 = copy(value = value * k)
  def addTag(t: String): Data1031 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1031 = copy(meta = meta.updated(k, v))
  def merge(other: Data1031): Data1031 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1031 {
  given Ordering[Data1031] = Ordering.by(_.id)
  def empty: Data1031 = Data1031(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1031 =
    Data1031(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1031] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
