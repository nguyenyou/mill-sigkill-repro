package generated

final case class Data1190(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1190 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1190 = copy(value = value * k)
  def addTag(t: String): Data1190 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1190 = copy(meta = meta.updated(k, v))
  def merge(other: Data1190): Data1190 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1190 {
  given Ordering[Data1190] = Ordering.by(_.id)
  def empty: Data1190 = Data1190(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1190 =
    Data1190(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1190] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
