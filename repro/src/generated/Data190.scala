package generated

final case class Data190(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data190 = copy(name = name.toUpperCase)
  def scale(k: Double): Data190 = copy(value = value * k)
  def addTag(t: String): Data190 = copy(tags = t :: tags)
  def put(k: String, v: String): Data190 = copy(meta = meta.updated(k, v))
  def merge(other: Data190): Data190 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data190 {
  given Ordering[Data190] = Ordering.by(_.id)
  def empty: Data190 = Data190(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data190 =
    Data190(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data190] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
