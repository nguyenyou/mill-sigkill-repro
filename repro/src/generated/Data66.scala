package generated

final case class Data66(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data66 = copy(name = name.toUpperCase)
  def scale(k: Double): Data66 = copy(value = value * k)
  def addTag(t: String): Data66 = copy(tags = t :: tags)
  def put(k: String, v: String): Data66 = copy(meta = meta.updated(k, v))
  def merge(other: Data66): Data66 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data66 {
  given Ordering[Data66] = Ordering.by(_.id)
  def empty: Data66 = Data66(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data66 =
    Data66(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data66] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
